<h2>Architecture Micro-services</h2>

<h3>Objectif</h3>
L'objectif de cette activité est de créer une application basée sur une architecture micro-service permettant de gérer les factures contenant des produits et appartenant à un client.
<br/>
<h3> L'architecture</h3>
<img src="captures/architecture.png">
<br/>
<ol>
<li>Création du micro-service "customer-service "</li>
Le micro-service "customer-service" permettra de gérer les clients.
<br/>
<h3>Structure du projet</h3>
<img src="captures/structure-projet.png">
<br/>
<br/>
<img src="captures/customer-service-structure.png">
<br/>
<br/>
<ul>
<li>Dépendance du micro-service : "customer-service"</li>
<br/>
<img src="captures/pomXML-customer.png">
<br/>
<br/>
<li>Entité - Customer.java</li>
<br/>
<img src="captures/customer.png">
<br/>
<br/>
<li>DTO - CustomerDTO.java</li>
<br/>
<img src="captures/CustomerDTO.png">
<br/>
<br/>
<li>Repository - CustomerRepository.java</li>
<br/>
<img src="captures/CustomerRepository.png">
<br/>
<br/>
<li>Mapper - CustomerMapper.java</li>
<br/>
<img src="captures/CustomerMapper.png">
<br/>
<br/>
<li>Controller - CustomerController.java</li>
<br/>
<img src="captures/CustomerController.png">
<br/>
<br/>
<li>Service - CustomerService.java</li>
<br/>
<img src="captures/CustomerService.png">
<br/>
<br/>
<li>Configuration - application.yml</li>
<br/>
<img src="captures/applicationYml.png">
<br/>
<br/>
<li>Main - CustomerServiceApplication.java</li>
<br/>
<img src="captures/CustomerApplication.png">
<br/>
<br/>
<li>Tests des endpoints</li>
<br/>
<img src="captures/testAllCustomers.png">
<br/>
<br/>
<img src="captures/swagger-customers.png">
<br/>
<img src="captures/testCustomerId.png">
<br/>
<img src="captures/testPOSTCustomer.png">
<br/>
<br/>
<img src="captures/resultPOSTCustomer.png">
</ul>
<li>Création du micro-service "inventory-service "</li>
<br/>
Le micro-service "inventory-service" permettra de gérer les produits et leur inventaire.
<br/>
<ul>
<li>Structure du micro-service : "inventory-service"</li>
<br/>
<img src="captures/inventoryStructure.png">
<br/>
<br/>
<li>Dépendances du micro-service : "inventory-service"</li>
<br/>
<img src="captures/pomInventory1.png">
<br/>
<img src="captures/pomInventory2.png">
<br/>
<img src="captures/pomInventory3.png">
<br/>
<img src="captures/pomInventory4.png">
<br/>
<br/>
<li>Entité - Product.java</li>
<br/>
<img src="captures/Product.png">
<br/>
<li>Entité - ProductDTO.java</li>
<br/>
<img src="captures/ProductDTO.png">
<br/>
<li>Repository - ProductRepository.java</li>
<br/>
<img src="captures/ProductRepository.png">
<br/>
<li>Mapper - ProductMapper.java</li>
<br/>
<br/>
<img src="captures/ProductMapper.png">
<br/>
<br/>
<li>Controller - ProductController.java</li>
<br/>
<img src="captures/ProductController1.png">
<br/>
<img src="captures/ProductController2.png">
<br/>
<br/>
<li>Service - ProductService.java</li>
<br/>
<br/>
<img src="captures/ProductService.png">
<br/>
<br/>
<li>Configuration - application.yml</li>
<br/>
<img src="captures/applicationYml.png">
<br/>
<br/>
<li>Main - InventoryServiceApplication.java</li>
<br/>
<img src="captures/MainProductService.png">
<br/>
<br/>
<li>Tests des endpoints</li>
<br/>
<img src="captures/getInventory.png">
<br/>
<br/>
<img src="captures/getInventoryId.png">
<br/>
<img src="captures/getInvent13.png">
<br/>
<br/>
<img src="captures/POSTInvent.png">
<br/>
<img src="captures/POSTInventResult.png">
</ul>
<br/>
<br/>
<li>Création de la Gateway "gateway-service "</li>
<br/>
LA Gateway est le point d'entrée unique qui gère toutes les requêtes entrantes pour router les demandes vers les micro-services appropriés, tout en centralisant des fonctionnalités transversales comme la sécurité, l'authentification, la limitation de débit, le routage intelligent, et l'équilibrage de charge, simplifiant ainsi la complexité pour les clients et les services backend.
<br/>
<ul>
<li>Structure du micro-service : "gateway-service</li>
<img src="captures/gatewayStructure.png">
<br/>
<br/>
<li>Dépendances du micro-service : "gateway-service"</li>
<br/>
<img src="captures/pomXMLGateway-service1.png">
<br/>
<img src="captures/pomXMLGateway-service2.png">
<br/>
<br/>
<li>Main - GatewayServiceApplication.java</li>
<br/>
<img src="captures/GatewayServiceApplication.png">
</ul>
<br/>
<li> Configuration statique du système de routage</li>
<br/>
<ul>
<li>application.properties</li>
<br/>
<img src="captures/applicationPropertiesGateway.png">
<br/>
<li>application.yml</li>
<br/>
<img src="captures/applicationYmlGateway.png">
<br/>
<li>Test de la Gateway</li>
<br/>
<img src="captures/testGateway1.png">
<br/>
<img src="captures/testGateway2.png">
<br/>
<br/>
<img src="captures/testGatway3.png">
<br/>
<img src="captures/testGatway4.png">
</ul>
<br/>
<li>Création de l'annuaire Eureka Discrovery Service</li>
<br/>
Ce service agit comme un registre où tous les microservices s'enregistrent.
C'est grâce à lui que les services peuvent se découvrir mutuellement.<br/>
Exemple : Le service Customer peut trouver le service Inventory en demandant à Eureka "Où est le service Inventory ?"
<br/>
<br/>
<ul>
<li>Structure du micro-service : "discovery-service"</li>
<br/>
<img src="captures/structure-discovery-service.png">
<br/>
<br/>
<li>Dépendances du micro-service : "discovery-service"</li>
<br/>
<img src="captures/discoveryServiceXML.png">
<br/>
<br/>
<li>Main - DiscoveryServiceApplication.java</li>
<br/>
<img src="captures/DiscoveryServiceApplication.png">
<br/>
<br/>
<li>application.properties</li>
<br/>
<img src="captures/applicationproperties-Discovery.png">
<br/>
<br/>
<li>Test de l'annuaire</li>
<br/>
<img src="captures/lb02.png">
<img src="captures/lb01.png">

</ul>
</ol>
