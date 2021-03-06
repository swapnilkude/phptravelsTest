package com.phpTravels.qa.analyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

//for handling more than 1 methods of fail

public class PhpTravelTransformer implements IAnnotationTransformer{
	
	//overriding parent methods
	public void transform(ITestAnnotation annotation, Class HomePageTest, Constructor testConstructor, Method testMethod){

		annotation.setRetryAnalyzer(RetryAnalyzer.class);
	}
}
