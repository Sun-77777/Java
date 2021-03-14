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
driver.find_element_by_link_text(u"添加歌曲").click()
driver.find_element_by_name("filename").send_keys("D:\\music\\蔡健雅,亚森,苏比依 - 别找我麻烦.mp3")
time.sleep(6)
driver.find_element_by_xpath("/html/body/form/table/tbody/tr[2]/td[2]/input").click()
time.sleep(6)
driver.find_element_by_name("singer").send_keys(u"蔡健雅")
time.sleep(6)
driver.find_element_by_xpath("/html/body/form/div[2]/input").click()
time.sleep(5)
#浏览器的滚动条拖动底端
js = "var q=document.documentElement.scrollTop=100000"
driver.execute_script(js)
time.sleep(5)

driver.quit()


