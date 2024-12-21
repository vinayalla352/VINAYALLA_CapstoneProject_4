import pytest
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

class TestCapstoneProject:
    def test_verify_homepage_title(self, browser, base_url):
        browser.get(base_url)
        assert browser.title == "The Internet", "Homepage title does not match"

    def test_checkboxes_page(self, browser, base_url):
        browser.get(f"{base_url}checkboxes")
        page_header = browser.find_element(By.TAG_NAME, "h3").text
        assert page_header == "Checkboxes", "Page header does not match"
        
        checkboxes = browser.find_elements(By.CSS_SELECTOR, "input[type='checkbox']")
        assert not checkboxes[0].is_selected(), "Checkbox 1 is incorrectly checked"
        assert checkboxes[1].is_selected(), "Checkbox 2 is incorrectly unchecked"

    def test_file_upload(self, browser, base_url):
        browser.get(f"{base_url}upload")
        page_header = browser.find_element(By.TAG_NAME, "h3").text
        assert page_header == "File Uploader", "Page header does not match"
        
        file_input = browser.find_element(By.ID, "file-upload")
        file_input.send_keys("C:\\Users\\Administrator\\PyhtonProject\\resources\\samplefile.txt")
        upload_button = browser.find_element(By.ID, "file-submit")
        upload_button.click()
        success_message = WebDriverWait(browser, 10).until(
            EC.presence_of_element_located((By.TAG_NAME, "h3"))
        ).text
        assert success_message == "File Uploaded!", "File upload failed"
