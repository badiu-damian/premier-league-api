from bs4 import BeautifulSoup
from io import StringIO
import pandas as pd
import time
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By
from webdriver_manager.chrome import ChromeDriverManager

options = webdriver.ChromeOptions()
options.add_argument("--start-maximized")
options.add_argument("--disable-blink-features=AutomationControlled")
options.add_experimental_option("excludeSwitches", ["enable-automation"])
options.add_experimental_option("useAutomationExtension", False)

driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()), options=options)
driver.execute_script("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})")

def get_soup(url, timeout=60):
    driver.get(url)
    WebDriverWait(driver, timeout).until(
        lambda d: "Just a moment" not in d.title
    )
    time.sleep(5)
    return BeautifulSoup(driver.page_source, 'lxml')

all_teams = []

try:
    soup = get_soup('https://fbref.com/en/comps/9/Premier-League-Stats')
    table = soup.find_all('table', class_='stats_table')[0]
    links = [l.get("href") for l in table.find_all('a')]
    links = [l for l in links if '/squads/' in l]
    team_urls = [f"https://fbref.com{l}" for l in links]
    print(f"Found {len(team_urls)} teams")

    for team_url in team_urls:
        team_name = team_url.split("/")[-1].replace("-Stats", "")
        print(f"Scraping {team_name}...")

        soup = get_soup(team_url)
        stats_tables = soup.find_all('table', class_='stats_table')

        if not stats_tables:
            print(f"  Skipping {team_name} — no table found")
            continue

        team_data = pd.read_html(StringIO(str(stats_tables[0])))[0]

        if isinstance(team_data.columns, pd.MultiIndex):
            team_data.columns = team_data.columns.droplevel()

        team_data["Team"] = team_name
        all_teams.append(team_data)
        time.sleep(6)

    stat_df = pd.concat(all_teams)
    stat_df.to_csv("stats.csv", index=False)
    print("Done! stats.csv saved.")

finally:
    driver.quit()
