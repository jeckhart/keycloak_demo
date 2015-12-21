package org.serenity.persistence.pdo

class CargoTest extends GroovyTestCase {
    void testEquals() {
        Location galley = new Location(id: 1, name: 'galley')
        Cargo spoons = new Cargo(id: 1, owner: 'test', count: 5, description: 'spoons', location: galley)
        Cargo forks = new Cargo(id: 2, owner: 'test', count: 5, description: 'forks', location: galley)

        Cargo spoonDupe = new Cargo(owner: 'test', count: 5, description: 'spoons', location: galley)


        assertFalse spoons.equals(forks)
        assertTrue spoonDupe.equals(spoons)

        println spoons

    }
}
