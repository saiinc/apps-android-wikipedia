package org.wikipedia.homeworks.homework18

import org.junit.runner.RunWith
import org.junit.runners.Suite
import org.wikipedia.homeworks.homework11.DeviceTest
import org.wikipedia.homeworks.homework13.WebViewTest

@RunWith(Suite::class)
@Suite.SuiteClasses(
    WebViewTest::class,
    DeviceTest::class
)

class TestSuite {
}