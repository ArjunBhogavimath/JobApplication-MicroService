# 📄 JobApplication-MicroService

A scalable and resilient microservices-based Job Application System built using **Spring Boot** and modern cloud-native tools. The application allows users to explore job opportunities, manage companies, and submit reviews—all powered by distributed services communicating via both synchronous and asynchronous protocols.

---

## 🛠️ Key Features

- 📦 **Microservices Architecture** with separation of concerns: Job Service, Company Service, Review Service
- 🔍 **Service Discovery** using **Eureka Server**
- 🌐 **API Gateway** for centralized routing and request filtering
- 🔁 **Inter-Service Communication**:
  - **RestTemplate** for synchronous calls
  - **RabbitMQ** for asynchronous event-driven messaging
- 🛡️ **Fault Tolerance** using **Resilience4J** (Retry, Circuit Breaker)
- 📊 **Distributed Tracing** with **Zipkin**
- 🐳 **Dockerized** services for containerized deployment
- ☸️ **Kubernetes** setup for orchestration and local cluster deployment

---

## ⚙️ Tech Stack

- **Backend:** Java, Spring Boot
- **Database:** PostgreSQL
- **Service Discovery:** Netflix Eureka
- **API Gateway:** Spring Cloud Gateway
- **Async Messaging:** RabbitMQ
- **Resilience:** Resilience4J
- **Tracing:** Zipkin
- **Containerization:** Docker
- **Orchestration:** Kubernetes (Minikube or local k8s)

---

## 🧱 Microservices Included

1. **Job Service** - Handles job creation and listings
2. **Company Service** - Manages company data
3. **Review Service** - Allows users to post company reviews
4. **API Gateway** - Routes external traffic to services
5. **Eureka Server** - Registers all microservices for discovery

---

## 📁 Folder Structure

```
JobApplication-MicroService/
│
├── job-service/               # Job listings logic
├── company-service/           # Company management
├── review-service/            # Company reviews logic
├── api-gateway/               # Gateway configuration
├── discovery-server/          # Eureka registration
├── docker-compose.yml         # Docker setup
├── k8s/                       # Kubernetes YAML manifests
└── README.md
```

---

## 🚀 Running the Project

### 1. Clone the repository
```bash
git clone https://github.com/ArjunBhogavimath/JobApplication-MicroService.git
cd JobApplication-MicroService
```

### 2. Start with Docker
```bash
docker-compose up --build
```

### 3. Or run with Kubernetes
```bash
kubectl apply -f k8s/
```

Make sure:
- Docker and Kubernetes (Minikube or Docker Desktop) are running
- PostgreSQL and RabbitMQ are configured (can be part of `docker-compose.yml`)

---

## 📡 Communication Architecture

- **REST (Sync):** Job ↔ Company ↔ Review via RestTemplate
- **RabbitMQ (Async):** Job events published and consumed by other services
- **Zipkin:** Captures trace data for all service-to-service calls

---

## 🧪 Future Improvements

- Add frontend (React/Vue) to visualize jobs and reviews
- Add Keycloak for authentication
- Add Prometheus & Grafana for metrics monitoring
- Use Spring Cloud Config for centralized configuration

---

## 🙋‍♂️ Author

**Mallikarjunaiah B M**  
📫 vpmallikarjuna03@gmail.com  
📞 +91-7619413484  
🌐 [LinkedIn](https://www.linkedin.com/in/mallikarjunaiah-b-m-1331a319a/)

---

Built with ☕ Spring Boot, crafted with ❤️ by Mallikarjunaiah B M
