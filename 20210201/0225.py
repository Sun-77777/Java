from selenium import webdriver
import time

driver = webdriver.Chrome()
driver.get("https://www.baidu.com/?tn=44004473_10_oem_dg")
driver.maximize_window()

driver.find_element_by_id("kw").send_keys("hhhhhh")
driver.find_element_by_id("su").click()

time.sleep(6)

driver.quit()
