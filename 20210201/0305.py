from selenium import webdriver
import time
import os
driver = webdriver.Chrome()
driver.get("https://www.baidu.com")

#浏览器的缩小
driver.minimize_window()
time.sleep(6)

#浏览器的放大
driver.maximize_window()
time.sleep(6)

#设置浏览器的宽和高
driver.set_window_size(400,800)
time.sleep(6)

#浏览器的滚动条拖动顶端
js = "var q=document.documentElement.scrollTop=0"
driver.execute_script(js)
time.sleep(5)

#浏览器的滚动条拖动底端
js = "var q=document.documentElement.scrollTop=100000"
driver.execute_script(js)
time.sleep(5)

#同时控制浏览器的左右，上下
js = "window.scrollTo(200,200);"
driver.execute_script(js)

time.sleep(8)
driver.quit()