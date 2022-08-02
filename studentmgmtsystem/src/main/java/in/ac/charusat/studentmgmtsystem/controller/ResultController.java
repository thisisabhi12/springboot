package in.ac.charusat.studentmgmtsystem.controller;

import in.ac.charusat.studentmgmtsystem.model.Result;
import in.ac.charusat.studentmgmtsystem.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResultController {
    @Autowired
    ResultRepository resultrepository;

    @GetMapping("/result/{id}")
    public Result getResult(@PathVariable Integer id) {
        return resultrepository.findById(id).get();
    }
    @GetMapping("listResults")
    public List<Result> getAllResults() {
        return resultrepository.findAll();
    }

    @PostMapping("/result")
    public List<Result> addResult(@RequestBody Result result) {
        resultrepository.save(result);
        return resultrepository.findAll();
    }
    @PutMapping("/result/{id}")
    public List<Result> updateResult(@RequestBody Result result,@PathVariable Integer id) {
        Result resultObj=resultrepository.findById(id).get();
        resultObj.setCourseId(result.getCourseId());
        resultObj.setPercentage(result.getPercentage());
        resultrepository.save(resultObj);
        return resultrepository.findAll();
    }
    @DeleteMapping("/result/{id}")
    public List<Result> deleteResult(@PathVariable Integer id) {
        resultrepository.delete(resultrepository.findById(id).get());
        return resultrepository.findAll();
    }
}
