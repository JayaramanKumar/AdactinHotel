package com.test.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources" }, glue = {"com.stepdefination"},plugin = {"pretty"}, dryRun = false, snippets = SnippetType.CAMELCASE, 
tags = {"@VerifyingBookingWithoutDetails"})
public class TestRunner {

}
