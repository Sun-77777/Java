from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.common.exceptions import NoSuchElementException
from selenium.common.exceptions import NoAlertPresentException
import unittest,time,re

class Baidu(unittest.TestCase):
    def setUp(self):
        self.driver = webdriver.Firefox()
        self.driver.implicitly_wait(30)
        self.base_url = "http://www.baidu.com/"
        self.verificationErrors = []
        self.accept_next_alert = True

    def test_baidusearch(self):
        driver = self.driver
        driver.get(self.base_url + "/")
        driver.find_element_by_id("kw").click()
        driver.find_element_by_id("kw").clear()
        driver.find_element_by_id("kw").send_keys(u"测试")
        driver.find_element_by_id("su").click()
    def test_hao(self):
        driver = self.driver
        driver.get(self.base_url + "/")
        driver.find_element_by_link_text("hao123").click()
        self.assertEqual(u"hao123_上网从这里开始",driver.title)


if __name__ == '__main__':
    unittest.main()

