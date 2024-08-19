package br.bolicos.api.dragons.domain.dragon;

import br.bolicos.api.dragons.UnitTest;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@UnitTest
class DragonTest {

    @Test
    void testDragonCreationWithBuilder() {
        String name = "Smaug";
        String breed = "Fire Drake";
        Integer age = 500;
        Integer size = 300;
        String power = "Fire Breath";
        String strength = "Strong";
        String health = "Excellent";
        String element = "Fire";
        String status = "Alive";
        boolean canFly = true;

        Dragon dragon = new Dragon.Builder(name, breed, age, size)
                .withPower(power)
                .withStrength(strength)
                .setHealth(health)
                .withElement(element)
                .setStatus(status)
                .canFly(canFly)
                .build();

        assertNotNull(dragon);
        assertNotNull(dragon.id());
        assertEquals(name, dragon.name());
        assertEquals(breed, dragon.breed());
        assertEquals(age, dragon.age());
        assertEquals(size, dragon.size());
        assertEquals(power, dragon.power());
        assertEquals(strength, dragon.strength());
        assertEquals(health, dragon.health());
        assertEquals(element, dragon.element());
        assertEquals(status, dragon.status());
        assertTrue(dragon.canFly());
    }

    @Test
    void testDragonCreationWithCustomId() {
        UUID customId = UUID.randomUUID();
        String name = "Fafnir";
        String breed = "Earth Drake";
        Integer age = 1000;
        Integer size = 400;

        Dragon dragon = new Dragon.Builder(customId, name, breed, age, size)
                .build();

        assertEquals(customId, dragon.id());
        assertEquals(name, dragon.name());
        assertEquals(breed, dragon.breed());
        assertEquals(age, dragon.age());
        assertEquals(size, dragon.size());
    }

    @Test
    void testDragonDefaults() {
        String name = "Alduin";
        String breed = "Sky Dragon";
        Integer age = 2000;
        Integer size = 500;

        Dragon dragon = new Dragon.Builder(name, breed, age, size)
                .build();

        assertNotNull(dragon.id());
        assertEquals(name, dragon.name());
        assertEquals(breed, dragon.breed());
        assertEquals(age, dragon.age());
        assertEquals(size, dragon.size());
        assertNull(dragon.power());
        assertNull(dragon.strength());
        assertNull(dragon.health());
        assertNull(dragon.element());
        assertNull(dragon.status());
        assertNull(dragon.canFly());
    }

    @Test
    void testDragonCanFly() {
        String name = "Toothless";
        String breed = "Night Fury";
        Integer age = 150;
        Integer size = 250;

        Dragon dragon = new Dragon.Builder(name, breed, age, size)
                .canFly(true)
                .build();

        assertTrue(dragon.canFly());
    }
}