package com.dw.test.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items")
public class MethodTestController {
    // Get 요청 (전체 아이템 조회)
    // URL: GET /api/items
    @GetMapping
    public String getAllItems() {
        System.out.println("GET /api/items 요청 수신");
        return "모든 아이템을 조회했습니다.";
    }

    // POST 요청 (새로운 아이템 생성)
    // URL: POST /api/items
    // Body: {"name": "아이템명"}
    @PostMapping
    public String createItem(@RequestBody String name) {
        System.out.println("POST /api/items 요청 수신");
        return name + " 아이템이 생성되었습니다.";
    }

    // PUT 요청 (특정 아이템 수정)
    // URL: PUT /api/items/{id}
    // Body: {"name": "아이템명"}
    @PutMapping("/{id}")
    public String updateItem(@PathVariable String id,
                             @RequestBody String item) {
        System.out.println("PUT /api/items 요청 수신");
        return "아이템 ID " + id + "가 " + item + " 으로 수정되었습니다.";
    }

    // DELETE 요청 (특정 아이템 삭제)
    // URL: DELETE /api/items?id=1234
    @DeleteMapping
    public String deleteItem(@RequestParam String id) {
        System.out.println("DELETE /api/items 요청 수신");
        return "아이템 ID " + id + "가 삭제되었습니다.";
    }
}






