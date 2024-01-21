package com.example.its.web.issue;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.IssuerUriCondition;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.its.domain.issue.IssueService;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String showCreationForm() {
        return "issues/creationForm";
    }
}