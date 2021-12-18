package com.ghassan;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {

    //URI: Uniform Resource Identifier
    //- It contains nine components
    //1-Scheme, -2 Scheme-specific part, 3- Authority, 4- User-info, 5- Host, 6- Port, 7- Path,
    //8- Query, 7- Fragment
    //The form : scheme:[//[user[:password]@host[:port]][/path][?query][#fragment]]
    //- URI can be relative or absolute
    //Relative means that the URI doesn't identify the resource completely
    //Absolute means that the URI identifies the resource completely
    //- URL must always be absolute
    public static void main(String[] args) {

       try {
           URI uri = new URI("http://username:password@myserver.com:5000/catalogue/" +
                   "phone?os=android#samsung");
           System.out.println("Scheme = " + uri.getScheme());
           System.out.println("Scheme-specific part = " + uri.getSchemeSpecificPart());
           System.out.println("Authority = " + uri.getAuthority());
           System.out.println("User info = " + uri.getUserInfo());
           System.out.println("Host = " + uri.getHost());
           System.out.println("Port = " + uri.getPort());
           System.out.println("Path = " + uri.getPath());
           System.out.println("Query = " + uri.getQuery());
           System.out.println("Fragment = " + uri.getFragment());
           System.out.println("==================================================");
           //Convert URI to URL
           System.out.println("Convert URI to URL: ");
           URL url = uri.toURL();
           System.out.println("URL = "+ url);
           System.out.println("==================================================");
           //Using a base URI that holds info doesn't change
           //then we use another URI that might change in the future
           //We can have an absolute URI by resolving the base URI with the other one
           // Then we can convert it to URL

           URI baseURI = new URI("http://username:password@myserver.com:5000");
           URI anotherURI = new URI("/catalogue/phone?os=android#samsung");
           URI resolvedURI = baseURI.resolve(anotherURI);
           System.out.println("The baseURI is : "+ baseURI+
                   "\nThe anotherURI is : "+ anotherURI +
                   "\nThe resolvedURI is : " + resolvedURI);
           //Convert the resolved URI to URL
           URL newURL = resolvedURI.toURL();
           System.out.println("The new URL is : " + newURL );
       }catch (URISyntaxException e){
           System.out.println("URI bad syntax: " + e.getMessage());
       }catch (MalformedURLException e){
           System.out.println("URL Malformed :" + e.getMessage());
       }
    }
}
