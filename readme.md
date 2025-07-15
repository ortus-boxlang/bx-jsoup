# ⚡︎ BoxLang Jsoup

```
|:------------------------------------------------------:|
| ⚡︎ B **Parameters:**

- `html` (string, required): The HTML string to parsex L a n g ⚡︎
| Dynamic : Modular : Productive |
| :----------------------------: |
```

<blockquote>
	Copyright Since 2023 by Ortus Solutions, Corp
	<br>
	<a href="https://www.boxlang.io">www.boxlang.io</a> |
	<a href="https://www.ortussolutions.com">www.ortussolutions.com</a>
</blockquote>

<p>&nbsp;</p>

A powerful BoxLang module that provides HTML parsing and cleaning capabilities using [Jsoup](https://jsoup.org/). This module enables developers to safely parse, manipulate, and clean HTML content with ease.

## Features

- **HTML Parsing**: Parse HTML strings into manipulable document objects
- **HTML Cleaning**: Sanitize HTML content with customizable safety levels
- **XSS Protection**: Built-in protection against Cross-Site Scripting attacks
- **Flexible Safelists**: Multiple predefined safety levels from strict to relaxed
- **CSS Selectors**: Extract elements using familiar CSS selector syntax
- **Relative Link Handling**: Control how relative links are processed during cleaning

## Installation

This module can be installed using CommandBox or the BoxLang Installer Scripts

```bash
# BoxLang Installer Script
install-bx-module bx-jsoup
# commandbox
box install bx-jsoup
```

## Available BIFs (Built-in Functions)

### htmlParse( html )

Parses an HTML string and returns a Jsoup Document object for manipulation.

**Parameters:**

- `html` (string, required): The HTML string to parse

**Returns:** A Jsoup Document object with methods for HTML manipulation

**Example:**

```javascript
// Parse HTML content
htmlContent = "<html><head><title>My Page</title></head><body><h1>Hello World</h1></body></html>";
doc = htmlParse( htmlContent );

// Access document properties
title = doc.title(); // Returns "My Page"
bodyText = doc.body().text(); // Returns "Hello World"

// Use CSS selectors
htmlContent = "<ul><li class='item'>Item 1</li><li class='item'>Item 2</li></ul>";
doc = htmlParse( htmlContent );
items = doc.select( ".item" ); // Returns elements with class 'item'

// Extract text content
textContent = doc.text(); // Returns plain text without HTML tags
```

**Common Document Methods:**

- `title()` – Get the contents of the `<title>` tag
- `select(selector)` – Find elements using CSS selectors
- `text()` – Get the combined text of the entire document
- `outerHtml()` – Get the HTML of the entire document
- `body()` – Get the `<body>` element
- `head()` – Get the `<head>` element
- `getElementById(id)` – Find an element by its ID attribute
- `getElementsByTag(tagName)` – Get all elements with the given tag
- `getElementsByClass(className)` – Get all elements with the given class
- `getElementsByAttribute(attrName)` – Get elements that have the specified attribute
- `html()` – Get the inner HTML of the document body
- `createElement(tagName)` – Create a new element with the given tag

### htmlClean( html, safeList, preserveRelativeLinks, baseUri )

Cleans and sanitizes HTML content to prevent XSS attacks and ensure safe rendering.

**Parameters:**
- `html` (string, required): The HTML string to clean
- `safeList` (string, optional): The safety level to apply (default: "relaxed")
- `preserveRelativeLinks` (boolean, optional): Whether to preserve relative links (default: false)
- `baseUri` (string, optional): Base URI for resolving relative links (default: "")

**Returns:** A cleaned HTML string

**Safelist Options:**
- `none`: Maximum cleaning, removes all tags and returns plain text only
- `simpletext`: Allows very limited inline formatting tags like `<b>`, `<i>`, `<br>`
- `basic`: Basic cleaning, removes all tags except for a few safe ones
- `basicwithimages`: Basic cleaning but allows images
- `relaxed`: More lenient cleaning, allows more tags (default)

**Examples:**

```javascript
// Basic cleaning with default "relaxed" safelist
dirtyHtml = "<script>alert('XSS')</script><p>Hello World!</p>";
cleanHtml = htmlClean( dirtyHtml );
// Result: "<p>Hello World!</p>"

// Strict cleaning with "basic" safelist
cleanHtml = htmlClean(
    html: "<img src='image.jpg' /><script>alert('XSS')</script><p>Hello World!</p>",
    safeList: "basic"
);
// Result: "<p>Hello World!</p>"

// Allow images with "basicwithimages" safelist
cleanHtml = htmlClean(
    html: "<img src='image.jpg' /><script>alert('XSS')</script><p>Hello World!</p>",
    safeList: "basicwithimages"
);
// Result: "<img src='image.jpg' /><p>Hello World!</p>"

// Plain text only with "none" safelist
cleanHtml = htmlClean(
    html: "<p><strong>Bold text</strong> and <em>italic text</em></p>",
    safeList: "none"
);
// Result: "Bold text and italic text"

// Preserve relative links
cleanHtml = htmlClean(
    html: "<a href='page.html'>Link</a>",
    preserveRelativeLinks: true
);
// Result: "<a href='page.html'>Link</a>"

// Convert relative links to absolute
cleanHtml = htmlClean(
    html: "<a href='page.html'>Link</a>",
    baseUri: "https://example.com/",
    preserveRelativeLinks: false
);
// Result: "<a href='https://example.com/page.html'>Link</a>"
```

## Use Cases

### Content Management Systems
Clean user-generated content before storing or displaying:

```javascript
userContent = "<p>Great article! <script>alert('hack')</script></p>";
safeContent = htmlClean( userContent );
// Store or display safeContent safely
```

### Web Scraping
Parse and extract data from HTML content:

```javascript
scrapedHtml = "<div class='product'><h2>Product Name</h2><span class='price'>$19.99</span></div>";
doc = htmlParse( scrapedHtml );
productName = doc.select( ".product h2" ).text();
price = doc.select( ".price" ).text();
```

### Email Template Processing
Clean HTML emails before sending:

```javascript
emailTemplate = "<p>Hello {{name}}, <script>malicious()</script></p>";
cleanTemplate = htmlClean( emailTemplate, "basic" );
// Process cleanTemplate safely
```

## Security Considerations

This module is designed with security in mind:

- **XSS Prevention**: All cleaning operations remove potentially dangerous scripts and attributes
- **Configurable Safety**: Choose the appropriate safelist level for your use case
- **Link Handling**: Control how relative links are processed to prevent malicious redirects
- **Input Validation**: Built-in validation ensures non-empty HTML input

## Dependencies

This module leverages the powerful [Jsoup](https://jsoup.org/) Java library for HTML parsing and cleaning. Jsoup provides:

- Robust HTML parsing with error recovery
- CSS selector support
- Comprehensive whitelist-based cleaning
- Standards-compliant HTML output

## Module Information

- **Version**: 1.0.0-snapshot
- **Author**: Luis Majano
- **BoxLang Mapping**: `bxJsoup`

## Ortus Sponsors

BoxLang is a professional open-source project and it is completely funded by the [community](https://patreon.com/ortussolutions) and [Ortus Solutions, Corp](https://www.ortussolutions.com). Ortus Patreons get many benefits like a cfcasts account, a FORGEBOX Pro account and so much more. If you are interested in becoming a sponsor, please visit our patronage page: [https://patreon.com/ortussolutions](https://patreon.com/ortussolutions)

### THE DAILY BREAD

> "I am the way, and the truth, and the life; no one comes to the Father, but by me (JESUS)" Jn 14:1-12
