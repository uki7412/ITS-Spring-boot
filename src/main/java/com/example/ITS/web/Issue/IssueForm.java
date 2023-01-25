package com.example.ITS.web.Issue;


import lombok.Data;//このロンボックはゲッターセッターなど。コンストラクタは→　import lombok.AllArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class IssueForm {

    @NotBlank
    @Size(max=256)
    private String summary;

    @NotBlank
    @Size(max=256)
    private String description;

}
