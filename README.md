Checklist
1. Login as standard_user and check that user is redirected to Products page
2. Click some item name and validate that user is redirected to item page
3. Click Add To Cart button on Item page and validate that item is added to cart (by counter and directly in cart)
4. Click Remove button on Item page → item is removed from cart
5. Click Back button → user is redirected to Products page
6. Click Add To Cart button on Products page → Item is added
7. Click Remove button on Products page → item is removed from cart
8. Click Reset App State → Cart is empty
9. Click About → user is redirected to https://saucelabs.com
10. Click Continue Shopping → user is redirected to Products page
11. Click Checkout → user is redirected to Checkout: Your Information
12. Click Cancel → user is redirected to Cart
13. Click Continue btn on Your Information → Error: First Name is required
14. On Your Information input FirstName and click Continue btn → Error: Last Name is required
15. On Your Information input Firs/Last Name and click Continue btn → Error: Postal Code is required
16. On Your Information input Firs/Last Name and Zip and click Continue btn → user is redirected to Checkout: Overview
17. On Checkout: Overview click Cancel → user is redirected to Products
18. On Checkout: Overview click Finish → user is redirected to THANK YOU FOR YOUR ORDER page
19. Logout → user is redirected to Login page
20. Login as locked_out_user and check that message 'Epic sadface: Sorry, this user has been locked out.' is displayed


//TODO

1. Implement WebDriverFactory with Capabilities
2. Add description into @BeforeMethod and @AfterMethod 
3. Fix LoginTest (by groups or either my removal of Inheritance)
4. Move all version into properties inside pom.xml
5. Create screenshots after failure of the test (TestNG listener)
6. Add reasons into assertions
7. CircleCI integration
8. Move WebDriverWait into BasePage
9. Implement openPage() and isPageOpened()
 