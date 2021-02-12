from selenium import webdriver
import time

driver = webdriver.Chrome()
driver.get("http://localhost:8080/java_image_server/index.html")
driver.maximize_window()

#删除图片
driver.find_element_by_xpath("//*[@id='container']/div[1]/button").click()
time.sleep(6)

alert = driver.switch_to.alert
time.sleep(5)
alert.accept()
time.sleep(5)
driver.quit()