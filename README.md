# 🛍️ Hamleys Age-Based Shopping Automation

This project automates the process of selecting age-specific products on the [Hamleys India website](https://www.hamleys.in), focusing on the **"12+ years"** category. It demonstrates advanced web automation techniques including wheel scrolling, slider interaction, filtering, and screenshot capture.

## 📌 Problem Statement

Automate the following tasks on the Hamleys website:

1. Scroll to the **"Shop By Age"** slider.
2. Move the slider to reveal and click the **"12+ years"** category.
3. Apply filters:
   - Sort products by **price: low to high**
   - Filter by **discount: 40–50%**
   - Ensure products are **in stock**
4. Retrieve and display the **number of matching products**.

## 🔍 Detailed Workflow

- Launch the Hamleys India website.
- Scroll down using wheel actions to locate the **"Shop By Age"** slider.
- Use mouse actions to slide and select the **"12+ years"** category.
- Apply sorting and filtering options:
  - Sort by price (ascending)
  - Filter by discount range (40–50%)
  - Filter by availability (in stock)
- Capture a screenshot of the filtered product list.
- Count and display the number of products shown.

## 🧰 Technologies Used

- Java
- Selenium WebDriver
- TestNG / JUnit
- Eclipse IDE

## 🎯 Key Automation Scope

- Wheel Actions: Scroll to dynamic elements
- Mouse Actions: Slider manipulation and category selection
- Screenshot Capture: Visual validation of filtered results

## 📸 Output

- Screenshot of the filtered product list
- Console output showing the number of products available in the **"12+ years"** category with applied filters
