@CrossOrigin(origins = "https://studenteventmgtdepl-qqjjq83ub-sthuthi2410236-9833s-projects.vercel.app")
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User registered successfully";
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> credentials) {
        User user = userRepository.findByEmail(credentials.get("email"));

        if (user != null && passwordEncoder.matches(credentials.get("password"), user.getPassword())) {

            Map<String, String> response = new HashMap<>();
            response.put("role", user.getRole());

            return response;
        }

        throw new RuntimeException("Invalid Credentials");
    }
}