package com.wine.to.up.sender.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class SenderConfiguration {
    @Bean("MessagesPool")
    public List<String> getMessagesPool() {
        return Arrays.asList("Humans can survive underwater. But not for very long.",
                "Cellular phones will not give you cancer. Only hepatitis.",
                "To make a photocopier, simply copy a mirror.",
                "At some point in their lives, one in six children will be abducted by the Dutch.",
                "The first person to prove that cow's milk is drinkable was very, very thirsty.",
                "Whales are twice as intelligent, and three times as delicious, as humans.",
                "Dreams are the subconscious mind's way of reminding people to go to school naked and have their teeth fall out.",
                "In 1948, at the request of a dying boy, baseball legend Babe Ruth ate seventy-five hot dogs, then died of hot dog poisoning.",
                "Marie Curie invented the theory of radioactivity, the treatment of radioactivity, and dying of radioactivity.",
                "William Shakespeare did not exist. His plays were masterminded in 1589 by Francis Bacon, who used a Ouija board to enslave play-writing ghosts.",
                "Before the Wright Brothers invented the airplane, anyone wanting to fly anywhere was required to eat 200 pounds of helium.",
                "During the Great Depression, the Tennessee Valley Authority outlawed pet rabbits, forcing many to hot glue-gun long ears onto their pet mice.",
                "In Greek myth, Prometheus stole fire from the gods and gave it to humankind. The jewelry he kept for himself.",
                "Edmund Hillary, the first person to climb Mount Everest, did so accidentally while chasing a bird.",
                "In Victorian England, a commoner was not allowed to look directly at the Queen, due to a belief at the time that the poor had the ability to steal thoughts. Science now believes that less than 4% of poor people are able to do this.");
    }
}
