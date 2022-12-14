package com.generation.blogpessoal.configuration;

import org.springdoc.core.customizers.OpenApiCustomiser;

import org.springframework.context.annotation.Bean; 
import io.swagger.v3.oas.models.ExternalDocumentation; 
import io.swagger.v3.oas.models.OpenAPI; 
import io.swagger.v3.oas.models.info.Contact; 
import io.swagger.v3.oas.models.info.Info; 
import io.swagger.v3.oas.models.info.License; 
import io.swagger.v3.oas.models.responses.ApiResponse; 
import io.swagger.v3.oas.models.responses.ApiResponses;
public class SwaggerConfig { 
 
 @Bean 
 public OpenAPI springBloblepessaolOpenAPI() { 
 return new OpenAPI() 
   .info(new Info() 
     .title("Projeto Blog Pessoal") 
     .description("Projeto Blog Pessoal - Generation Brasil") 
     .version("v0.0.1") 
    .license(new License() 
     .name("João Victor Lopes de Lima") 
     .url("https://www.linkedin.com/in/jo%C3%A3o-victor-b6ba59221/")) 
    .contact(new Contact() 
     .name("João Victor Lopes de Lima") 
     .url("https://github.com/ProjectzJV") 
     .email("vitorg8_2011@hotmail.com"))) 
    .externalDocs(new ExternalDocumentation() 
     .description("Github") 
     .url("https://github.com/ProjectzJV/BlogPessoal-Deploy")); 
 } 
 
 
 
@Bean 
public OpenApiCustomiser customerGlobalHeaderOpenApiCustomiser() { 
  
 return openApi -> { 
  openApi.getPaths().values().forEach(pathItem -> pathItem.readOperations().forEach(operation -> { 
    
   ApiResponses apiResponses = operation.getResponses(); 
    
   apiResponses.addApiResponse("200", createApiResponse("Sucesso!")); 
   apiResponses.addApiResponse("201", createApiResponse("Objetivo Persistido!")); 
   apiResponses.addApiResponse("204", createApiResponse("Ojetivo Excluido!")); 
   apiResponses.addApiResponse("400", createApiResponse("Erro na Requisição!")); 
   apiResponses.addApiResponse("401", createApiResponse("Acesso Não Autorizado")); 
   apiResponses.addApiResponse("404", createApiResponse("Ojetivo Não Encotrado!")); 
   apiResponses.addApiResponse("500", createApiResponse("Erro na Aplicação!")); 
  })); 
 }; 
} 
private ApiResponse createApiResponse(String message) { 
 return new ApiResponse().description(message); 
} 
 
}