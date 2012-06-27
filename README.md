trainme
=======

A silly but semi-useful spring project for teaching unit, integration
and functional testing.

Currently this project is using a few frameworks, and is hacking around
with uniutils and dbunit. However, ignore uniutils and dbunit in the
project.

This project shows:

- unit test with a stub
- unit test with Mockito mocks
- integration testing with @RunWith / @ContextConfiguration
- a simple controller with a single restful method (see
  CourseController)
- seeding of data using jdbc:initialize-database

The project will be extended this week to include configuration for
jenkins.


