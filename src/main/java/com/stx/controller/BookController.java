package com.stx.controller;

import com.stx.pojo.Books;
import com.stx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //controller 层掉service
    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    //查询全部书籍，并返回一个页面
    @RequestMapping("/allBook")
    public String list(Model model) {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        return "allBook";
    }

    //跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPage() {
        return "addBook";
    }

    //增加书籍
    @RequestMapping("/addBook")
    public String addBook(Books books) {
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }

    //跳转修改界面
    @RequestMapping("/toUpdate")
    public String toUpdate(int id, Model model) {
        Books books = bookService.queryBookById(id);
        model.addAttribute("QBook", books);
        return "updateBook";
    }

    //修改
    @RequestMapping("/updateBook")
    public String updateBook(Books books) {
        System.out.println("updateBook=" + books);
        int i = bookService.updateBook(books);
        if (i > 0) {
            System.out.println("添加成功" + books);
        }
        return "redirect:/book/allBook";
    }

    //删除
    @RequestMapping("/deleteBook")
    public String deleteBook(int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }
    //查询
    @RequestMapping("/toSelectBook")
    public String selectBook(String queryBookName, Model model) {
        Books books = bookService.queryBookByName(queryBookName);
        List<Books> list = new ArrayList<Books>();
        list.add(books);
        if (books == null) {
            list = bookService.queryAllBook();
            model.addAttribute("error", "未查到书籍");
        }
        model.addAttribute("list", list);
        return "allBook";
    }
}
