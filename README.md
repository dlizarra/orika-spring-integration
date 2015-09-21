# orika-spring-integration
Example on how to integrate Orika mapper into Spring the simplest and most effective way possible.

## OrikaBeanMapper [(class)](src/main/java/com/dlizarra/orika/mapper/OrikaBeanMapper.java)
- Configures the Orika MapperFactory and factory builder.
- Registers into the MapperFactory all CustomConverter and CustomMapper classes annotated with `@Component`.
- To use it we just need to autowire it into the class and we'll be able to map any combination of classes with it:

  ```java
  @Autowired
  private OrikaBeanMapper mapper;
  private User user;
  
  user = MockUtils.mockUser();
  UserDto dto = mapper.map(user, UserDto.class);
  ```
  
## Custom Mappers [(example)](src/main/java/com/dlizarra/orika/mapper/custom/UserUserDtoMapper.java)
- Create a class that extends `CustomMapper` whenever you need to customize the mapping between two classes.
- Override `mapAtoB` and/or `mapBtoA` methods and implement the logic on how to map the attributes that need a specific way of being mapped. The fields not specified here will be mapped by default, i.e. matching by name and copying the value from one bean to the other.
- Annotate the class with `@Component` so it can be discovered by `OrikaBeanMapper`.

## Custom Converters [(example)](src/main/java/com/dlizarra/orika/converter/AddressToStringConverter.java)
- Create a class that extends `CustomConverter` whenever you need to tell Orika how to convert a class type to another when a mapping is being done.
- Implement `convert` method.
- Annotate the class with `@Component` so it can be discovered by `OrikaBeanMapper`.

### References
- Orika Mapper GitHub project: http://github.com/orika-mapper
