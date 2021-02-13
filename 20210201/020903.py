from selenium import webdriver
import unittest
import time

class imageTest(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Chrome()
        self.driver.get("http://localhost:8080/java_image_server/index.html")
        self.driver.maximize_window()
        time.sleep(3)
    def tearDown(self):
        self.driver.quit()

    def test_upload(self):
        self.driver.find_element_by_name("filename").send_keys("d:/")
        time.sleep(3)
        self.driver.find_element_by_xpath("//*[@id='blog-collapse']/form/div[2]/input").click()
        time.sleep(6)
    @unittest.skip("skipping")
    def test_delete(self):
        self.driver.find_element_by_xpath("//*[@id='container']/div[1]/button").click()
        time.sleep(6)
        self.alert = self.driver.switch_to.alert
        time.sleep(6)
        self.alert.accept()
        time.sleep(6)

    if __name__ == '__main__':
         unittest.main()

