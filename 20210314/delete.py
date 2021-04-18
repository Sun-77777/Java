from selenium import webdriver
import time
from selenium.webdriver.common.keys import Keys
#from selenium.webdriver.common.action_chains import ActionChains

driver = webdriver.Chrome()
driver.get("http://localhost:8080/login.html")

driver.find_element_by_id("user").send_keys("111")
time.sleep(5)
driver.find_element_by_id("user").send_keys(Keys.TAB)
time.sleep(5)
driver.find_element_by_id("password").send_keys("111")
time.sleep(5)
#driver.find_element_by_id("password").send_keys(Keys.ENTER)
driver.find_element_by_id("submit1").click()
time.sleep(5)
alert = driver.switch_to.alert
text = alert.text
print("text = " + text)
time.sleep(5)
alert.accept()
time.sleep(6)
driver.maximize_window()
time.sleep(5)
js = "var q=document.documentElement.scrollTop=100000"
driver.execute_script(js)
time.sleep(5)

driver.find_element_by_xpath("//*[@id='info']/tr[11]/td[4]/button[1]").click()
time.sleep(5)
alert = driver.switch_to.alert
text = alert.text
print("text = " + text)
time.sleep(5)
alert.accept()
time.sleep(5)

js = "var q=document.documentElement.scrollTop=100000"
driver.execute_script(js)
time.sleep(5)

driver.quit()
