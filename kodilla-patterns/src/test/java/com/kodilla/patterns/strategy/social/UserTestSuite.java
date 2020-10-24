package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User damian = new Millenials("Damian");
        User angelika = new YGeneration("Angelika");
        User dominika = new ZGeneration("Dominika");

        //When
        String damianFavoriteSocialMedia = damian.sharePost();
        System.out.println("Damian's favorite social media is " + damianFavoriteSocialMedia);
        String angelikaFavoriteSocialMedia = angelika.sharePost();
        System.out.println("Angelika's favorite social media is " + angelikaFavoriteSocialMedia);
        String dominikaFavoriteSocialMedia = dominika.sharePost();
        System.out.println("Dominika's favorite social media is " + dominikaFavoriteSocialMedia);

        //Then
        Assert.assertEquals("Facebook.com", damianFavoriteSocialMedia);
        Assert.assertEquals("Twitter.com", angelikaFavoriteSocialMedia);
        Assert.assertEquals("Snapchat.com", dominikaFavoriteSocialMedia);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User damian = new Millenials("Damian");

        //When
        String damianFavoriteSocialMedia = damian.sharePost();
        System.out.println("Damian's favorite social media is " + damianFavoriteSocialMedia);
        damian.setSocialPublisher(new SnapchatPublisher());
        damianFavoriteSocialMedia = damian.sharePost();
        System.out.println("Damian changed his favorite social media to " + damianFavoriteSocialMedia);

        //Then
        Assert.assertEquals("Snapchat.com", damianFavoriteSocialMedia);
    }
}
