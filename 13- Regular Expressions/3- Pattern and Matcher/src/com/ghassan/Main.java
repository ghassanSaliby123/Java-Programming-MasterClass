package com.ghassan;

import com.sun.security.jgss.GSSUtil;
import com.sun.source.tree.ParameterizedTypeTree;

import javax.sql.rowset.serial.SerialStruct;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    //The Pattern class complies the regular expression which specified as a string through compile() method
    // and provides a pattern that can be used with the Matcher class which matches arbitrary
    // character sequences against the regular expression.
    // The Matcher works with any class that implement the CharSequence interface
    // such as String, StringBuilder and StringBuffer
    //We usually use Matcher when we want to find multiple occurrences of a pattern or when we want to
    // use the same pattern with multiple sequences
    //We use () to define groups
    //We use ? to have a lazy quantifier 0 or 1 occurrence
    public static void main(String[] args) {

        //We want to find the all occurrences of h2 tag of html
        StringBuilder htmlText = new StringBuilder("<h1> Heading <.h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This a paragraph 1</p>");
        htmlText.append("<p>This a paragraph 2</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>This a paragraph 3</p>");

        String h2Pattern = "<h2>";
        //Compile the h2Pattern to a pattern
        Pattern pattern = Pattern.compile(h2Pattern);
        //Match the pattern to our text
        Matcher matcher = pattern.matcher(htmlText);
        System.out.println(matcher.matches());

        //Reset the internal state for the matcher
        matcher.reset();
        int count = 0;
        while (matcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " + matcher.start() + " to " + matcher.end());
        }
        System.out.println("===================================================================");

        //Using group matcher () always start with 1 because group 0 is the entire pattern
        //Here there is one group
        String h2GroupPattern = "(<h2>.*?</h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());

        while (groupMatcher.find()) {
            System.out.println("Occurrence: " + groupMatcher.group(1));
        }
        System.out.println("===================================================================");
        //Three groups
        String h2TextGroup = "(<h2>)(.+?)(</h2>)";
        Pattern h2TextPattern = Pattern.compile(h2TextGroup);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);
        System.out.println(h2TextMatcher.matches());

        while (h2TextMatcher.find()) {
            //we get the second group to have the text between the tags
            System.out.println("Occurrence: " + h2TextMatcher.group(2));
        }
    }
}
