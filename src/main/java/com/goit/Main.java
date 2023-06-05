package com.goit;

import com.goit.CRUD.ClientCrudService;
import com.goit.CRUD.PlanetCrudService;

public class Main {

    public static void main(String[] args) {
        ClientCrudService clientCrudService = new ClientCrudService();
        PlanetCrudService planetCrudService = new PlanetCrudService();

        Client client = new Client();
        client.setName("Баба Яга");

        Planet planet = new Planet();
        planet.setName("Mars");

        clientCrudService.createClient(client);
        planetCrudService.createPlanet(planet);

        Client retrievedClient = clientCrudService.getClientById(client.getId());
        Planet retrievedPlanet = planetCrudService.getPlanetById(planet.getId());

        System.out.println("Retrieved Client: " + retrievedClient.getName());
        System.out.println("Retrieved Planet: " + retrievedPlanet.getName());

        clientCrudService.deleteClient(client);
        planetCrudService.deletePlanet(planet);

        // Verify that the client and planet were deleted
        Client deletedClient = clientCrudService.getClientById(client.getId());
        Planet deletedPlanet = planetCrudService.getPlanetById(planet.getId());

        // Print the result of the deletion
        System.out.println("Deleted Client: " + (deletedClient == null ? "null" : deletedClient.getName()));
        System.out.println("Deleted Planet: " + (deletedPlanet == null ? "null" : deletedPlanet.getName()));
    }
}
