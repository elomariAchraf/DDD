package com.pmu.mvp.exposition;

import com.pmu.mvp.application.CourseService;
import com.pmu.mvp.domain.Course;
import com.pmu.mvp.exposition.converter.CourseConverter;
import com.pmu.mvp.exposition.dto.CourseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    private final CourseConverter courseConverter;

    @PostMapping("")
    @Operation(summary = "créer et publier une course",
            description = """
                    API permettant de créer des courses et leurs
                    partants, de stocker les informations en base
                    de données et de les exposer au reste du SI par un
                    message publié sur un bus.
                    """)
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Course created and published successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input or validation error"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<String> addAndPublishCourse(@RequestBody CourseDto courseDto) {
        Course course = courseConverter.toCourse(courseDto);
        Course courseSaved = courseService.save(course);
        courseService.publish(courseSaved);
        return ResponseEntity.ok("Course créée et publié avec succès ");
    }
}
