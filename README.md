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
<img src="captures/customerDTO.png">
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
</ul>
</ol>
