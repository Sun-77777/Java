from selenium import webdriver
import time
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.action_chains import ActionChains
import os
driver = webdriver.Chrome()
driver.get("https://www.baidu.com/")

driver.maximize_window()
driver.find_element_by_id("kw").send_keys("端午节")
#定位
su1 = driver.find_element_by_id("su")
ActionChains(driver).context_click(su1).perform()

time.sleep()