Project Title

  JLP Project

Project Description

  Android App that will allow customers to see the range of dishwashers on sale at John Lewis.

Features

    Product grid displaying dishwashers available for purchase at John Lewis.
    Detailed product view when a dishwasher is selected.
    Adaptive UI for both mobile and tablet devices with distinct designs.
    MVVM architecture with clean code practices.
    Unit tests following TDD principles.
    Integration Tests
    Certificate pinning for enhanced network security.
    ProGuard rules for code obfuscation.
    Caching mechanism for API calls.
    Accessibility features for inclusive user experience.
    Optimized code and custom components like CustomerRow and Text.

Assumptions

 The product data is fetched from a predefined API endpoint.
 The app requires an active internet connection for the initial data fetch.

Usage
The app provides a user-friendly interface allowing customers to browse and learn more about dishwashers available at John Lewis. 

Viewing Dishwasher Products
Upon launching the app, you will be presented with a grid of dishwashers. Each item in the grid represents a dishwasher available for purchase, displaying its image and basic information.
You can just scroll through the grid to view the different dishwasher models.

Accessing Product Details

To learn more about a specific dishwasher, simply tap on the product in the grid.
The app will navigate to the product details page, where you can view:

A horizontal pager that allows you to swipe through multiple images of the selected dishwasher.
Detailed product information, including features and pricing.Product specifications that provide technical details about the dishwasher.

Navigating Back to the Product Grid

To return to the grid of dishwasher products from the details page, tap on the back arrow icon located at the top-left corner of the screen.

You will be taken back to the main grid, where you can continue browsing other products.

The app is designed to work seamlessly on both mobile and tablet devices, offering an optimized experience with layouts tailored to each device type. On tablets, the product details page features a two-pane layout that displays the product images and specifications alongside the information for easy comparison.


Known Issues

In the development and testing phase of the app, a couple of issues were identified, particularly related to the accessibility features when tested on an emulator. 

1) Accessibility Double Click Issue: 
It has been observed that sometimes the double-click action required for product selection does not register properly when accessibility features, such as TalkBack, are enabled. This issue was encountered during testing on an emulator.

2) Horizontal Pager Swipe Issue: 
Another issue identified involves the horizontal pager on the product details page, which does not seem to respond to swipe gestures after enabling accessibility features. This behaviour was also noted during emulator testing.

The known accessibility issues identified during testing on an emulator, specifically related to the double-click action and horizontal pager swipe, have not been found on a device like the OnePlus 8T. Further testing on additional devices is required to confirm if these issues are emulator-specific and do not persist in real-world usage scenarios. Updates or fixes for these issues will be addressed in future app releases to ensure optimal accessibility across various devices.

Future Improvements

1) Offline mode with persistent data storage.
2) Authentication and Authorization
