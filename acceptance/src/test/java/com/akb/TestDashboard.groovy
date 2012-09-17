package com.akb

import com.thoughtworks.selenium.SeleneseTestCase

public class TestDashboard extends SeleneseTestCase {

    public void setUp() {
        setUp "http://localhost:8080/no3b/", "*safari"
    }

    void testClickMinegishi() {
        selenium.open("/no3b")
        selenium.waitForPageToLoad("20000")
        assertTrue(selenium.isTextPresent("NO3B"))
        selenium.fireEvent("id=minegishi-popularity-button", "click")
        sleep(20000l)
        assertTrue(selenium.isTextPresent("Loving"))
    }

    void testClickKojiharu() {
        selenium.open("/no3b")
        selenium.waitForPageToLoad("20000")
        assertTrue(selenium.isTextPresent("NO3B"))
        selenium.fireEvent("id=kojiharu-popularity-button", "click")
        sleep(20000l)
        assertTrue(selenium.isTextPresent("Loving"))
    }

    void testClickTakamina() {
        selenium.open("/no3b")
        selenium.waitForPageToLoad("20000")
        assertTrue(selenium.isTextPresent("NO3B"))
        selenium.fireEvent("id=takamina-popularity-button", "click")
        sleep(20000l)
        assertTrue(selenium.isTextPresent("Loving"))
    }
}