<template>
  <vue-bpmn
    url="/public/diagram.bpmn"
    v-on:error="handleError"
    v-on:shown="handleShown"
    v-on:loading="handleLoading"
  ></vue-bpmn>
</template>
<script>
import VueBpmn from 'vue-bpmn';
export default{
  name: '',
  components: {
    VueBpmn,
  },
  data(){
    return {

    };
  },
  methods: {
    handleError: function(err) {
      console.error('failed to show diagram', err);
    },
    handleShown: function() {
      console.log('diagram shown');
    },
    handleLoading: function() {
      console.log('diagram loading');
    }
  },
  mounted(){

  }
}
</script>
<style lang="scss" scoped>

</style>
