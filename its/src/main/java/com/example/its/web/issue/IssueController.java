package com.example.its.web.issue;

import com.example.its.domain.issue.IssueEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.IssuerUriCondition;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.its.domain.issue.IssueService;

@Controller
@RequestMapping("/issues")
@RequiredArgsConstructor
public class IssueController {

    // フィールドインジェクションを行う
    private final IssueService issueService;

    // GET /issue
    @GetMapping()
    public String showList(Model model) {

        // Thymeleafにオブジェクトを渡す
        model.addAttribute("issueList", issueService.findAll());
        // view名を指定
        return "issues/list";
    }

    @GetMapping("/creationForm")
    public String showCreationForm(@ModelAttribute IssueForm form) {
        return "issues/creationForm";
    }

    @PostMapping
    public String create(@Validated IssueForm form, BindingResult bindingResult, Model model) {
        // バリデーションエラー時の処理
        if (bindingResult.hasErrors()) {
            return showCreationForm(form);
        }
        issueService.create(form.getSummary(), form.getDescription());
        return "redirect:/issues";
    }
    @GetMapping("/{issueId}")
    public String showDetail(@PathVariable("issueId") long issueId, Model model) {
        model.addAttribute("issue", issueService.findById(issueId));
        return "issues/detail";
    }
}