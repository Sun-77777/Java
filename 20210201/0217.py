from selenium import webdriver
import time
import os
driver = webdriver.Chrome()
file_path = 'file:///' +os.path.abspath("")
driver.get(file_path)
time.sleep(3)
#driver.implicitly_wait(1)
driver.maximize_window()

#定位点击按钮
driver.find_element_by_id("tooltip").click()
time.sleep(5)
#得到操作alert弹出框的句柄
alert = driver.switch_to.alert
#输出弹出框的内容
text = alert.text
print("text = " + text)
time.sleep(5)
#关闭弹出框
alert.accept()
time.sleep(5)
driver.quit()