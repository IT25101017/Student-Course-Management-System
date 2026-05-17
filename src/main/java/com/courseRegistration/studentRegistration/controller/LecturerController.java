package com.courseRegistration.studentRegistration.controller;


@RestController
@RequestMapping("/api/lecturers")
@CrossOrigin(origins = "*")
public class LecturerController {
    private final LecturerService lecturerService;

    public LecturerController(LecturerService lecturerService) {
        this.lecturerService = lecturerService;
    }

    @PostMapping("/register")
    public AuthResponse register(@RequestBody LecturerRegistrationRequest request) {
        return lecturerService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LecturerLoginRequest request) {
        return lecturerService.login(request);
    }

    @GetMapping
    public List<Lecturer> getAllLecturers() {
        return lecturerService.getAllLecturers();
    }

    @GetMapping("/{id}")
    public Lecturer getLecturerById(@PathVariable Long id) {
        return lecturerService.getLecturerById(id);
    }


}
