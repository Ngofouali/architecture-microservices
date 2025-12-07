<h2>Architecture Micro-services</h2>

<h3>Objectif</h3>
L'objectif de cette activité est de créer una pplication basée sur une architecture micro-service permettant de gérer les factures contenat des produits et appartenat à un client.
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
<img src="captures/resultPOSTCustomer.png">
</ul>
<li>Création du micro-service "inventory-service "</li>
Le micro-service "inventory-service" permettra de gérer les produits et leur inventaire.
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
<li>Création de la Gateway "gateway-service "</li>
</ol>
