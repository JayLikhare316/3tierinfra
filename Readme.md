# 3-Tier Infrastructure on AWS

This repository contains Terraform code to deploy a complete 3-tier architecture on AWS, consisting of:

1. **Presentation Layer**: S3 static website hosting
2. **Application Layer**: EKS (Elastic Kubernetes Service) cluster
3. **Data Layer**: RDS MySQL database

## Architecture Overview

The infrastructure is organized as follows:

```
├── main.tf           # Main configuration file that calls the modules
├── modules/          # Directory containing the infrastructure modules
    ├── eks/          # EKS cluster configuration
    ├── rds/          # RDS database configuration
    ├── s3/           # S3 bucket for static website hosting
```

## Components

### Presentation Layer (S3)
- Static website hosting with S3
- Public access enabled for website content
- Custom error handling

### Application Layer (EKS)
- Managed Kubernetes cluster
- Node group with t3.medium instances
- Auto-scaling configuration
- IAM roles and policies for proper access

### Data Layer (RDS)
- MySQL 8.0 database
- DB subnet group for proper networking
- Security group with MySQL port (3306) access
- Storage auto-scaling enabled

## Prerequisites

- AWS CLI configured with appropriate credentials
- Terraform v0.12+ installed
- Access to create AWS resources (IAM, S3, EKS, RDS)

## Usage

1. Clone the repository:
   ```
   git clone https://github.com/JayLikhare316/3tierinfra.git
   cd 3tierinfra
   ```

2. Initialize Terraform:
   ```
   terraform init
   ```

3. Review the execution plan:
   ```
   terraform plan
   ```

4. Apply the configuration:
   ```
   terraform apply
   ```

5. To destroy the infrastructure:
   ```
   terraform destroy
   ```

## Configuration

The main configuration parameters can be adjusted in the `main.tf` file:

- AWS region (currently set to `us-east-2`)
- EKS cluster configuration:
  - Node count (min, max, desired)
  - Instance type
  - Project name

## Security Considerations

- The S3 bucket is configured with public read access for website hosting
- The RDS instance has a security group allowing inbound traffic on port 3306
- Consider restricting access in production environments

## Notes

- This infrastructure uses the default VPC and subnets for simplicity
- For production use, consider implementing:
  - Custom VPC with proper network segmentation
  - More restrictive security groups
  - Secrets management for database credentials
  - HTTPS for the S3 website

## License

This project is licensed under the MIT License - see the LICENSE file for details.
