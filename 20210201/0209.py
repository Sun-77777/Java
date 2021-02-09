from selenium import webdriver
import time

driver = webdriver.Chrome()
driver.get("http://localhost:8080/java_image_server/index.html")
driver.maximize_window()

#上传  绝对路径
#选择了图片
driver.find_element_by_name("filename").send_keys("C:\\Users\\18591\\Pictures\\me.jpg")
time.sleep(6)
#点击上传按钮
driver.find_element_by_xpath("//*[@id='blog-collapse']/form/div[2]/input").click()
time.sleep(6)
driver.quit()



