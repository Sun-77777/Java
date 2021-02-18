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

#div块
#点击click
driver.find_element_by_id("show_modal").click()
time.sleep(5)
#定位modal-body
div1 = driver.find_element_by_class_name("modal-body")
driver.find_element_by_link_text("click me").click()
time.sleep(5)
#定位modal-footer
div2 = driver.find_element_by_class_name("modal-footer")
buttons = div2.find_element_by_tag_name("button")
buttons[0].click()

#定位上传文件按钮
driver.find_element_by_tag_name("input").send_keys("d:/")
driver.quit()