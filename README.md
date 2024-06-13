# Selenium WebDriver Test Automation Project

This project is a test automation suite using Selenium WebDriver, designed to automate various interactions on the website [Tutorials Ninja](https://tutorialsninja.com/demo/index.php?route=common/home). The project is implemented using Java with the TestNG framework for structuring and running the tests. The automated test cases cover a range of user actions, from navigating through the website to performing a complete checkout process.

## Table of Contents
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Project Structure](#project-structure)
- [Test Cases](#test-cases)
  - [Test Case 1: Maximizing the Browser Window](#test-case-1-maximizing-the-browser-window)
  - [Test Case 2: Navigating to All Desktops](#test-case-2-navigating-to-all-desktops)
  - [Test Case 3: Adding an Item to the Cart and Proceeding to Checkout](#test-case-3-adding-an-item-to-the-cart-and-proceeding-to-checkout)
  - [Test Case 4: Selecting Guest Checkout](#test-case-4-selecting-guest-checkout)
  - [Test Case 5: Filling in Billing Details](#test-case-5-filling-in-billing-details)
  - [Test Case 6: Proceeding with the Shipping Method](#test-case-6-proceeding-with-the-shipping-method)
  - [Test Case 7: Agreeing to Terms and Conditions](#test-case-7-agreeing-to-terms-and-conditions)
  - [Test Case 8: Confirming the Order](#test-case-8-confirming-the-order)
  - [Test Case 9: Completing the Checkout Process](#test-case-9-completing-the-checkout-process)
- [Running the Tests](#running-the-tests)
- [Contributing](#contributing)
- [License](#license)

## Prerequisites

Before you begin, ensure you have the following installed on your machine:
- Java Development Kit (JDK) 8 or higher
- [Maven](https://maven.apache.org/) for dependency management
- [Google Chrome](https://www.google.com/chrome/) web browser
- [ChromeDriver](https://sites.google.com/chromium.org/driver/) compatible with your version of Chrome

## Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/your-username/selenium-webdriver-test-automation.git
   ```
2. Navigate to the project directory:
   ```sh
   cd selenium-webdriver-test-automation
   ```
3. Install the project dependencies using Maven:
   ```sh
   mvn install
   ```

## Project Structure

The project consists of a single Java class `TestCases` containing multiple test methods annotated with TestNG's `@Test` annotation. Each test method represents a different step or action in the automated test suite.

```
selenium-webdriver-test-automation/
│
├── src/
│   └── test/
│       └── java/
│           └── TestCases.java
│
├── pom.xml
├── README.md
└── testng.xml
```

## Test Cases

### Test Case 1: Maximizing the Browser Window

This test maximizes the browser window to ensure all elements are visible and accessible.
```java
@Test
public void testCase1() throws InterruptedException {
    driver.manage().window().maximize();
    Thread.sleep(4000);
}
```

### Test Case 2: Navigating to All Desktops

This test simulates the user hovering over the "Desktops" menu and clicking "Show All Desktops".
```java
@Test
public void testCase2() throws InterruptedException {
    Actions action = new Actions(driver);
    WebElement desktop = driver.findElement(By.linkText("Desktops"));
    action.moveToElement(desktop).build().perform();
    Thread.sleep(2000);
    WebElement showAllDesktop = driver.findElement(By.linkText("Show AllDesktops"));
    showAllDesktop.click();
    Thread.sleep(4000);
}
```

### Test Case 3: Adding an Item to the Cart and Proceeding to Checkout

This test adds the "HP LP3065" item to the cart and proceeds to the checkout page.
```java
@Test
public void testCase3() throws InterruptedException {
    driver.findElement(By.linkText("HP LP3065")).click();
    Thread.sleep(4000);
    driver.findElement(By.xpath("//button[@id='button-cart']")).click();
    Thread.sleep(4000);
    driver.findElement(By.xpath("//i[@class='fa fa-shopping-cart']")).click();
    Thread.sleep(4000);
    driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();
    Thread.sleep(4000);
}
```

### Test Case 4: Selecting Guest Checkout

This test selects the guest checkout option.
```java
@Test
public void testCase4() throws InterruptedException {
    driver.findElement(By.xpath("//input[@type='radio'][@value='guest']")).click();
    driver.findElement(By.xpath("//input[@id='button-account']")).click();
    Thread.sleep(4000);
}
```

### Test Case 5: Filling in Billing Details

This test fills in the billing details form.
```java
@Test
public void testCase5() throws InterruptedException {
    driver.findElement(By.xpath("//input[@id='input-payment-firstname']")).sendKeys("Siddhartha");
    driver.findElement(By.xpath("//input[@id='input-payment-lastname']")).sendKeys("Chakaraborty");
    driver.findElement(By.xpath("//input[@id='input-payment-email']")).sendKeys("sid@gmail.com");
    driver.findElement(By.xpath("//input[@id='input-payment-telephone']")).sendKeys("123456789");
    driver.findElement(By.xpath("//input[@id='input-payment-address-1']")).sendKeys("Kolaghat");
    driver.findElement(By.xpath("//input[@id='input-payment-city']")).sendKeys("Kolaghat");
    driver.findElement(By.xpath("//input[@id='input-payment-postcode']")).sendKeys("721212");
    Select country = new Select(driver.findElement(By.xpath("//select[@id='input-payment-country']")));
    country.selectByIndex(3);
    Thread.sleep(3000);
    Select objSelect = new Select(driver.findElement(By.xpath("//select[@id='input-payment-zone']")));
    objSelect.selectByIndex(2);
    driver.findElement(By.xpath("//input[@id='button-guest']")).click();
    Thread.sleep(4000);
}
```

### Test Case 6: Proceeding with the Shipping Method

This test proceeds with the selected shipping method.
```java
@Test
public void testCase6() throws InterruptedException {
    driver.findElement(By.xpath("//input[@id='button-shipping-method']")).click();
    Thread.sleep(4000);
}
```

### Test Case 7: Agreeing to Terms and Conditions

This test agrees to the terms and conditions and proceeds to the payment method.
```java
@Test
public void testCase7() throws InterruptedException {
    driver.findElement(By.xpath("//input[@name='agree']")).click();
    Thread.sleep(2000);
    driver.findElement(By.xpath("//input[@id='button-payment-method']")).click();
    Thread.sleep(4000);
}
```

### Test Case 8: Confirming the Order

This test confirms the order.
```java
@Test
public void testCase8() throws InterruptedException {
    driver.findElement(By.xpath("//input[@id='button-confirm']")).click();
    Thread.sleep(4000);
}
```

### Test Case 9: Completing the Checkout Process

This test clicks the continue button after the order confirmation.
```java
@Test
public void testCase9() {
    driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).click();
}
```

## Running the Tests

To run the tests, use the following command:
```sh
mvn test
```

This will execute all the test cases defined in the `TestCases` class.

## Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
