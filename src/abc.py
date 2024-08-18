from selenium import webdriver
from selenium.webdriver.chrome.service import Service
import time

# Path to your Chrome driver executable.
driver_path = '/Users/jatinpatel/Downloads/chromedriver-mac-arm64/chromedriver'

# Create a service object
service = Service(driver_path)

# Start the service
service.start()

# Instantiate a new webdriver with the service object
driver = webdriver.Chrome(service=service)

# URL of the login page
url = "https://app.townsq.io/login"

# Open the login page
driver.get(url)

# Add a delay to ensure the page is loaded
#time.sleep(3)

# Find the "Log in" button and click it
login_button = driver.find_element("xpath", "//span[contains(text(), 'Log in')]")
login_button.click()

# Add a delay to ensure the page is loaded
#time.sleep(2)

# Find the username and password input fields and fill them with your credentials
username_field = driver.find_element("xpath", "//input[@formcontrolname='username' and @data-cy='login-card--input--email']")
username_field.send_keys("20225kearney@gmail.com")

# Find the password input field and fill it with your password
password_field = driver.find_element("xpath", "//input[@formcontrolname='password' and @data-cy='login-card--input--password']")
password_field.send_keys("ryjciv-5zugve-cutciK")

# Find the "Log in" button and click it
login_button = driver.find_element("xpath", "//button[contains(., 'Log in')]")
login_button.click()

# Find the <div> element containing the text "Meadows of Blackhawk HOA" and click it
element = driver.find_element("xpath", "/html/body/comm-app-root/condo-selection/div/div/div/ul/li[2]/div[1]")
element.click()

# Find the <span> element with the specified attributes and text content and click it
span_element = driver.find_element("xpath", "//span[text()='Check my payments']")
span_element.click()

# Find the <div> element with the class "balance-number"
div_element = driver.find_element("class name", "balance-number")
balance_number = div_element.text.strip()
print("Balance number:", balance_number)

# Add a delay to let the next page load
time.sleep(5)

# Close the browser
driver.quit()