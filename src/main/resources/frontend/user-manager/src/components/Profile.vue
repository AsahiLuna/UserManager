<template>
  <div class="profile container" id="profile">
    <h1 class="text-center">{{ msg }}</h1>
    <form class="form-horizontal col-sm-8" role="form">
      <div class="form-group">
        <label for="name" class="col-sm-2 control-label">Name</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="name" 
              placeholder="Please input your name">
        </div>
      </div>
      <div class="form-group">
        <label for="gender" class="col-sm-2 control-label">Gender</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="gender" 
              placeholder="Please select your gender">
        </div>
      </div>
      <div class="form-group">
        <label for="birth-date" class="col-sm-2 control-label">Birth Date</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="birth-date" 
              placeholder="Please select your Birth Date">
        </div>
      </div>
      <div class="form-group">
        <label for="phone-number" class="col-sm-2 control-label">Phone Number</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="phone-number" 
              placeholder="Please input your phone number">
        </div>
      </div>
      <div class="form-group">
        <label for="email" class="col-sm-2 control-label">Email</label>
        <div class="col-sm-10">
          <input type="text" class="form-control" id="email" 
              placeholder="Please input your Email">
        </div>
      </div>
      <div class="form-group">
        <div class="col-sm-offset-2 col-sm-10">
          <button type="submit" class="btn btn-primary">Save</button>
          <button type="submit" class="btn btn-warning">Cancel</button>
        </div>
      </div>
    </form>
    <router-view/>
  </div>
</template>

<script>
export default {
  name: "profile",
  data() {
    return {
      msg: "Welcome to Your profile Page"
    };
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
