import pytest
from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By

@pytest.fixture(scope="class")
def browser():
    service = Service("resources\chromedriver.exe")
    driver = webdriver.Chrome(service=service)
    driver.maximize_window()
    yield driver

    driver.quit()

@pytest.fixture
def base_url():
    return "http://the-internet.herokuapp.com/"
