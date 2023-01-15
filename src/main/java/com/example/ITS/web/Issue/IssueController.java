package com.example.ITS.web.Issue;

import com.example.ITS.domain.issue.IssueEntity;
import com.example.ITS.domain.issue.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/issues")//GetMappingのパス/issues をまとめて略せる
@RequiredArgsConstructor //finalかつ初期化されていないフィールドを初期化するコンストラクタを自動生成する。
public class IssueController {
    private final IssueService issueService;//ここのnew issueServiceは消せる
    // GET /issuesというリクエストが来た時に処理するメソッド
    @GetMapping
    public String showList(Model model) {
        model.addAttribute("issueList",issueService.findAll());
        return "issues/list";
    }

    @GetMapping("/creationForm")//GET /issues/creationFormというリクエストがきた時に処理するハンドラーメソッド
    public String showCreationForm(@ModelAttribute IssueForm form) {
        return "issues/creationForm";
    }

    @PostMapping
    public String create(@Validated @ModelAttribute IssueForm form, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return showCreationForm(form);
        }
        issueService.create(form.getSummary(), form.getDescription());
        return "redirect:/issues";
    }
}
