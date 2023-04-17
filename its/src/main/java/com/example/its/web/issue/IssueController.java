package com.example.its.web.issue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.IssuerUriCondition;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.its.domain.issue.IssueService;

@Controller
public class IssueController {

    // フィールドインジェクションを行う
    @Autowired
    IssueService issueService;

    // GET /issue
    @GetMapping("/issues")
    public String showList(Model model) {

        // Thymeleafにオブジェクトを渡す
        model.addAttribute("issueList", issueService.findAll());
        // view名を指定
        return "issues/list";
    }
}