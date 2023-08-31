package dev.ellie.blogcontentmanagmentsystem.models;


import org.springframework.data.annotation.Id;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record Post(

    @Id
    Integer id,
    @NotBlank(message = "name should not be blank")
    String creatorName,
    @NotBlank(message = "post name should not be blank")
    String postName,
    @NotBlank(message = "content should not be blank")
    @Size(min=20,max=1000, message = "content should be between 20 to 1000 characters long")
    String content,
    int likes,
    int dislikes
) {
    
}
